package Aplayer;


public class APlayer {
	
	private String name;
	public APlayer(String name) {
		this.name = name;
	}
public String[][] grid;
public String playerPosition = "playerPosition";
public boolean gameStart = false;
public int row;
public int col;
public String treasure = "treasure";
public String direction;
public boolean startChecker = false;
public boolean dirChecker = false;
public boolean change = false;
public boolean gameend = false;
public int lifecount;
public int tries;
int treasureRow; 
int treasureCol;
public void setname(String name) {
	for (int i =0; i< name.length(); i++) {
		if((int) name.charAt(i)>=0 && (int) name.charAt(i)<=64 ||(int) name.charAt(i)>=0 )
	}
}

public void gridInitial(int row, int col){
	if(row <= 10) {
		System.out.println("Your row input should be greater than  10");
	}if(col <= 10) {
		System.out.println("Your column input should be greater than 10");
	}
	if(row> 10 && col > 10) {
		if(col % 2 != 0 || row % 2 !=0){
			if(col % 2 ==0) {
				System.out.println("your column needs to be an odd number");
			} if(row % 2 ==0) {
				System.out.println("your row needs to be an odd number");
			}
			if(col % 2 != 0 && row % 2 !=0) {
				this.row = row;
				this.col = col;
				this.grid = new String[row][col];
				startChecker = true;
				System.out.println("You have created a "+ Integer.toString(this.row) + " X " + Integer.toString(this.col) + ", so let's begin!" );
				System.out.println("");
				System.out.println(this.name+ ", if you get a direction wrong, your life count decreases" + " and if the life count is empty, you are left to die and the compass dissappears.");
				this.treasureRow =(int)(Math.random()* ((this.row)-1));
				this.treasureCol =(int)(Math.random()* ((this.col)-1));
				this.lifecount = 3;
				System.out.println("");
				System.out.println("Your life count is : " + Integer.toString(this.lifecount));
				
			}
			
		} else {
			System.out.println("");
			System.out.println("your column and row have to be odd numbers");
		}
		
	}
	
	
}

public void gameplay(String direction) {
	 this.direction = direction.toUpperCase();
	 System.out.println(direction.toUpperCase());
	 
	if(this.direction.equals("NORTH") || this.direction.equals("SOUTH")|| this.direction.equals("EAST") || this.direction.equals("WEST")) {
		dirChecker =true;
		if(dirChecker == true) {
			
			this.direction = direction.toUpperCase();
		//	grid[this.treasureRow][this.treasureCol] = treasure; 
			grid[0][0] = treasure;
			treasureRow = 0;
			treasureCol =this.col-1;
			
			System.out.println(this.treasureRow);
			System.out.println(this.treasureCol);
			
			if(gameStart == false) {
				this.grid[(row-1)/2][(col-1)/2] = playerPosition;
				System.out.println("A compass has appeared and your start position is [" + Integer.toString((row-1)/2) + ", " + Integer.toString((col-1)/2) + "]") ;
				System.out.println("");
				gameStart = true;
				
				
				switch(this.direction) {
				  case "NORTH" :
					  northCal(this.direction, treasureRow);
					  break;
				  case "SOUTH" :
					  southCal(this.direction, treasureRow);
					  break; 
				  case "EAST" :
					  eastCal(this.direction, treasureCol);
					  break;
				  case "WEST" :
					  westCal(this.direction, treasureCol);
					   break;
				  default:
					  System.out.println("wrong entry");
					  break;
				}
						
			} 
			
			else {
				
				
				if(!gameend) {
					switch(this.direction) {
					  case "NORTH" :
						  northCal(this.direction, treasureRow);
						  break;
					  case "SOUTH" :
						  southCal(this.direction, treasureRow);
						  break; 
					  case "EAST" :
						  eastCal(this.direction, treasureCol);
						  break;
					  case "WEST" :
						  westCal(this.direction, treasureCol);
						   break;
					  default:
						  System.out.println("wrong entry");
						  break;
					}
					
					for(int i= 0; i < grid.length ; i++) {
						
						for(int j =0; j < grid.length ; j++) {
							
							if(grid[i][j] != null) {
								if(grid[i][j].equals(playerPosition)) {
									if(i == treasureRow &&  j == treasureCol){
									        System.out.println("");
											System.out.println("You have found the treasure and a door would open into a new world!");
											gameend = true;
									}
								}
								
								
							}
						}
					}
					if(lifecount == 0) {
						System.out.println("");
						System.out.println("The compass is gone and you have been left to die in the forest!");
						gameend = true;
					}
				}
				
				
			}
		     dirChecker = false;
		}
		
	} else {
		System.out.println("You entered the wrong direction");
	}


}

public void northCal(String direction, int row) {
	int treasureRow = row;
	 for(int i =0; i< this.col; i++) {
		 for (int j= 0; j< this.col; j++) {
			 if(grid[i][j] != null) {
						if(grid[i][j].equals(playerPosition)) {
							if(i==0 ) {
								System.out.println("you have reached the edge of the grid ");
								System.out.println("");
								System.out.println("You stay at the same spot");
							} else {
								if(treasureRow < i ) {
									grid[i][j] = null;
									grid[i-1][j] = playerPosition;
									System.out.println("");
									System.out.println("You have moved up one place and your new position is : " + "[" + Integer.toString(i-1) + " , " + Integer.toString(j) + "]");
									change = true;
									break;
									
								} else if(treasureRow > i ) {
									System.out.println("");
									System.out.println("Wrong direction! You stay at the same spot");
									tries +=1;
									if(tries == 1) {
										lifecount-=1;
										System.out.println("");
										System.out.println("Your life count is: " + Integer.toString(lifecount));
										tries = 0;
									}
									break;
								} else if(treasureRow == i) {
									if(i== this.row-1) {
										System.out.println("");
										System.out.println("You have reached the edge of the forest grid");
									}
									System.out.println("");
									System.out.println("Wrong direction! You stay at the same spot");
									tries+=1;
									if(tries == 1) {
										lifecount-=1;		
										System.out.println("");
										System.out.println("Your life count is: " + Integer.toString(lifecount));
										tries = 0;
									}
									break;
								}
								if(change) {
									break;
								}
								
							}
							

							if(change) {
								break;
							}
						}

					if(change) {
						break;
					}
			 }

				if(change) {
					break;
				}
		 }

		 if(change) {
				change = false;
				break;
			}
	 }
}

public void southCal(String direction, int row) {
	int treasureRow = row;
		for (int i =0; i < grid.length; i++) {
			for(int j = 0; j < grid.length; j++) {
		
				if(grid[i][j] != null) {
					if(grid[i][j].equals(playerPosition)) {
						if(i==0 ) {
							System.out.println("you have reached the edge of the forest grid ");
							System.out.println("");
							System.out.println("You stay at the same spot");
						} else {
							if(treasureRow < i ) {
								System.out.println("");
								System.out.println("Wrong direction! You stay at the same spot");
								tries+=1;
								if(tries == 1) {
									lifecount-=1;
									System.out.println("");
									System.out.println("Your life count is: " + Integer.toString(lifecount));
									tries = 0;
								}
								
								break;
							} 
							
							else if(treasureRow > i ) {
								grid[i][j] = null;
								grid[i+1][j] = playerPosition;
								System.out.println("");
								System.out.println("You have moved down one place and your new position is : " + "[" + Integer.toString(i+1) + " , " + Integer.toString(j) + "]");
								change = true;
								break;
								
							} else if(treasureRow == i) {
								if(i== this.row-1) {
									System.out.println("");
									System.out.println("You have reached the edge of the forest grid");
								}
								System.out.println("");
								System.out.println("wrong direction");
								tries+=1;
								if(tries == 1) {
									lifecount-=1;
									System.out.println("");
									System.out.println("Your life count is: " + Integer.toString(lifecount));
									tries = 0;
								}
								break;
							}
							if(change) {
								break;
							}
						}
						
						if(change) {
							break;
						}
					}
					if(change) {
						break;
					}
				}
				if(change) {
					break;
				}
			}
			
			if(change) {
				change = false;
				break;
			}
	}
	
}

public void eastCal(String direction, int col) {
	int treasureCol = col;
	for (int i =0; i < grid.length; i++) {
		for(int j = 0; j < grid.length; j++) {
			if(grid[i][j] != null) {
				if(grid[i][j].equals(playerPosition)) {
					if(j == 0) {
						System.out.println("you have reached the edge of the grid ");
						System.out.println("");
						System.out.println("You stay at the same spot");
					} else {
						if(treasureCol < j ) {
							System.out.println("");
							System.out.println("Wrong direction! You stay at the same spot");
							tries+=1;
							if(tries == 1) {
								lifecount-=1;
								System.out.println("");
								System.out.println("Your life count is: " + Integer.toString(lifecount));
								tries = 0;
							}
							break;
							
						} 
						
						else if(treasureCol > j ) {
							grid[i][j] = null;
							grid[i][j+1] = playerPosition;
							System.out.println("");
							System.out.println("You have moved right one place and your new position is : " + "[" + Integer.toString(i) + " , " + Integer.toString(j+1) + "]");
							break;	
						} 
						
						else if(treasureCol == j) {
							if(j== this.col-1) {
								System.out.println("");
								System.out.println("You have reached the edge of the forest grid");
							}
							System.out.println("");
							System.out.println("Wrong direction! You stay at the same spot");
							tries+=1;
							if(tries == 1) {
								lifecount-=1;
								System.out.println("");
								System.out.println("Your life count is: " + Integer.toString(lifecount));
								tries = 0;
							}
							break;
						}
						if(change) {
							break;
						}
					}
					
					if(change) {
						break;
					}
				}
				if(change) {
					break;
				}
				
			}
			if(change) {
				break;
			}
			
		}
		if(change) {
			change = false;
			break;
		}
   }
}

public void westCal(String direction, int col) {
	int treasureCol = col;
	for (int i =0; i < grid.length; i++) {
		for(int j = 0; j < grid.length; j++) {
			if(grid[i][j] != null) {
				if(grid[i][j].equals(playerPosition)) {
					if(j == 0) {
						System.out.println("you have reached the edge of the grid ");
						System.out.println("");
						System.out.println("You stay at the same spot");
					} else {
						if(treasureCol < j ) {
							grid[i][j] = null;
							grid[i][j-1] = playerPosition;
							System.out.println("");
							System.out.println("You have moved left one place and your new position is : " + "[" + Integer.toString(i) + " , " + Integer.toString(j-1) + "]");	
							break;	
							
						} else if(treasureCol > j ) {
							System.out.println("");
							System.out.println("Wrong direction! You stay at the same spot");
							tries+=1;
							if(tries == 1) {
								lifecount-=1;
								System.out.println("");
								System.out.println("Your life count is: " + Integer.toString(lifecount));
								tries = 0;
							}
							break;
						} else if(treasureCol == j) {
							if(j== this.col-1) {
								System.out.println("");
								System.out.println("You have reached the edge of the forest grid");
							}
							System.out.println("");
							System.out.println("Wrong direction! you stay at the same spot");
							tries+=1;
							if(tries == 1) {
								lifecount-=1;
								System.out.println("");
								System.out.println("Your life count is: " + Integer.toString(lifecount));
								tries = 0;
							}
							break;
						}
						if(change) {
							break;
						}
					}
					
					if(change) {
						break;
					}
				}
				if(change) {
					break;
				}
			}
			if(change) {
				break;
			}
			
		}
		if(change) {
			change = false;
			break;
		}
   }
}


}
