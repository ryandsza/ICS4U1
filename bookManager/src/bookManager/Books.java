package bookManager;

public class Books {
	private String 	bookTitle;
    private String bookAuthor;
    private int ISBN;
    private boolean isAvailable;
    
    
    /*
	 * method getTitle
	 * Method to get book title
	 * Return Values: string
	 */
    public String getTitle() {
        return this.bookTitle;
    }
    
	/*
	 * method setTitle
	 * parameter: string title
	 * Method set the bookTitle to title
	 * Return Values: non
	 */
    public void setTitle(String title) {
        this.bookTitle = title;
    }
    
    /*
	 * method getAuthor
	 * Method to get author
	 * Return Values: string
	 */
    public String getAuthor() {
        return this.bookAuthor;
    }
    
	/*
	 * method setAuthor
	 * parameter: string author
	 * Method set the bookAuthor to author
	 * Return Values: non
	 */
    public void setAuthor(String author) {
        this.bookAuthor = author;
    }
    
    /*
	 * method getISBN
	 * Method to get ISBN
	 * Return Values: int
	 */
    public int getISBN() {
        return this.ISBN;
    }

	/*
	 * method setISBN
	 * parameter: int ISBN
	 * Method set the ISBN
	 * Return Values: non
	 */
    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
    
    public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	/*
	 * method setBookData
	 * parameter:
	 * String bookTitle title of the book
	 * String bookAuthor: author of the book
	 * int ISBN: ISBN of the book
	 *
	 * Method use to set book Data
	 * Return Values: non
	 */
	public void setBookData(String bookTitle, String bookAuthor, int ISBN, boolean isAvailable) {
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.ISBN = ISBN;	
		this.isAvailable = isAvailable;
	}
		
	/*
	 * method copyBookData
	 * parameter:
	 * Books source
	 * Method use to copy data
	 * Return Values: non
	 */
	public void copyBookData(Books source) {
		setBookData(
				source.getTitle(),
				source.getAuthor(),
				source.getISBN(),
				source.isAvailable()
				);
	}
	
	/*
	 * method toString
	 * Method to display the book information such as title, author, and ISBN
	 * 
	 */
    public String toString() {
    	 return String.format("%-40s %-40s %-20s %n",this.getTitle(),this.getAuthor(),this.getISBN());
    }
}