package concertseatmap;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Venue {
	private Seat[][] seats;
	
	public Venue(int row, int col, double price){
		seats = new Seat[row][col];
		for(int i = 0; i < seats.length; i ++) {
			for(int j = 0; j < seats[i].length; j ++) {
				seats[i][j] = new Seat(false, "R", price);
			}
		}
	}
	public boolean buyTicket(int row, int col) {
		if(!(seats[row][col].getSold())) {
			seats[row][col].setSold(true);
			return true;
		}
		else
			return false;
	}
	private boolean isAvailable(int row, int col) {
		if((seats[row][col].getSold())) {
			return true;
		}
		else
			return false;
	}
	public void setPremium(int row, double price) {
		for(int i = 0; i < seats[row].length; i ++) {
			seats[row][i].setType("P");
			seats[row][i].setPrice(price);
		}
	}
	public void setPremium(int row, int colStart, int colEnd, double price) {
		for(int i = colStart; i < colEnd; i ++) {
			seats[row][i].setType("P");
			seats[row][i].setPrice(price);
		}
	}
	public void setGA(int row, double price) {
		for(int i = 0; i < seats[row].length; i ++) {
			seats[row][i].setType("G");
			seats[row][i].setPrice(price);
		}
	}
	public boolean importTickets(String filename) throws IOException{
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		String line = "";
		int com = 0;
		int row = 0;
		int col = 0;
		while(scan.hasNextLine()) {
			line = scan.nextLine();
			com = line.indexOf(",");
			row = Integer.valueOf(line.substring(0, com));
			col = Integer.valueOf(line.substring(com+1));
			seats[row][col].setSold(true);
		}
		scan.close();
		return true;
	}
	public double totalRevenue() {
		double total = 0.0;
		for(int i = 0; i < seats.length; i ++) {
			for(int j = 0; j < seats[i].length; j ++) {
				if(seats[i][j].getSold()) {
					total += seats[i][j].getPrice();
				}
			}
		}
		return total;
	}
	public double totalRevenue(int col) {
		double total = 0;
		for(int j = 0; j < seats.length; j ++) {
			if(seats[j][col].getSold()) {
				total += seats[j][col].getPrice();
			}
		}
		return total;
	}
	public int totalSold() {
		int total = 0;
		for(int i = 0; i < seats.length; i ++) {
			for(int j = 0; j < seats[i].length; j ++) {
				if(seats[i][j].getSold()) {
					total ++;
				}
			}
		}
		return total;
	}
	public int totalSold(int row) {
		int total = 0;
		for(int i = 0; i < seats[row].length; i ++) {
				if(seats[row][i].getSold()) {
					total ++;
				}
			}
		return total;
	}
	public void printVenue() {
//		for(Seat[] s: seats) {
//			for(Seat st: s) {
//				System.out.print(s);
//			}
//			System.out.println();
//		}
		for(Seat[] s: seats) {
			for(Seat st: s) {
				System.out.print(st.getSold() + " ");
			}
			System.out.println();
		}
		
	}
	public void printVenueType() {
		for(Seat[] s: seats) {
			for(Seat st: s) {
				System.out.print(st.getType() + " ");
			}
			System.out.println();
		}
	}
	public void printVenuePrice() {
		for(Seat[] s: seats) {
			for(Seat st: s) {
				System.out.print(st.getPrice() + " ");
			}
			System.out.println();
		}
	}
	public double maxPrice(int rowStart, int rowEnd, int colStart, int colEnd) {
		double max = 0;
		for(int i = rowStart; i < rowEnd; i ++) {
			for(int j = colStart; j < colEnd; j ++) {
				if(seats[i][j].getPrice() > max) {
					max = seats[i][j].getPrice();
				}
			}
		}
		return max;
	}
	public boolean containsGA(int row) {
		for(Seat s: seats[row]) {
			if(s.getType().equals("G")) {
				return true;
			}
		}
		return false;
	}
	public boolean allPremium(int col) {
		for(Seat[] s: seats) {
			if(!(s[col].getType().equals("P"))) {
				return false;
			}
		}
		return true;
	}
	
}
