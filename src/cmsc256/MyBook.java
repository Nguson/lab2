package cmsc256;

    public class MyBook implements Comparable<MyBook> {
        private String title;
        private String authorFirstName;
        private String authorLastName;
        private String ISBN10;
        private String ISBN13;


        public MyBook() {
            title = "None Given";
            authorFirstName = "None Given";
            authorLastName = "None Given";
            ISBN10 = "0000000000";
            ISBN13 = "0000000000000";
        }

        public MyBook(String title, String authorFirstName, String authorLastname, String ISBN10, String ISBN13) {
            this.title = title;
            this.authorFirstName = authorFirstName;
            this.authorLastName = authorLastname;
            this.ISBN10 = ISBN10;
            this.ISBN13 = ISBN13;
        }


        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            if (title == null) {
                throw new IllegalArgumentException("Not a valid input");

            }
            this.title = title;
        }

        public String getAuthorFirstName() {
            return authorFirstName;
        }

        public void setAuthorFirstName(String authorFirstName) {
            if (authorFirstName == null) {
                throw new IllegalArgumentException("Not a valid input");
            }
            this.authorFirstName = authorFirstName;
        }

        public String getAuthorLastName() {
            return authorLastName;
        }

        public void setAuthorLastName(String authorLastName) {
            if (authorLastName == null) {
                throw new IllegalArgumentException("Not a valid input");
            }
            this.authorLastName = authorLastName;
        }

        public String getISBN10() {
            return ISBN10;
        }

        public void setISBN10(String ISBN10) {
            if(ISBN10 == null || ISBN10.length() != 10)
                throw new IllegalArgumentException("Not a valid input");
            for(int i = 0; i < ISBN10.length(); i++){
                if(!(Character.isDigit(ISBN10.charAt(i))))
                    throw new IllegalArgumentException();
            }
            this.ISBN10 = ISBN10;
        }

        public String getISBN13() {
            return ISBN13;
        }

        public void setISBN13(String ISBN13) {
            if(ISBN13 == null || ISBN13.length() != 13)
                throw new IllegalArgumentException("Not a valid input");
            for(int i = 0; i < ISBN13.length(); i++){
                if(!(Character.isDigit(ISBN13.charAt(i))))
                    throw new IllegalArgumentException();
            }
            this.ISBN13 = ISBN13;
        }

        @Override
        public String toString() {
            return "Title: " + getTitle() + "\n" + "Author: " + getAuthorFirstName() + " " + getAuthorLastName() +
                    "\n" + "ISBN10: " + getISBN10() + "\n" + "ISBN13: " + getISBN13();

        }
        public boolean equals(Object otherBook) {
            if (this == otherBook) {
                return true;
            }
        if(!(otherBook instanceof MyBook)){
            return false;
            }
            MyBook other = (MyBook)otherBook;
            if(!(ISBN10.equals(other.getISBN10())))
                return false;
            if(!(ISBN13.equals(other.getISBN13())))
                return false;
            return true;
        }
        public int compareTo(MyBook other){
            int result = this.authorLastName.compareTo(other.getAuthorLastName());

            if (result == 0){
                result = this.authorFirstName.compareTo(other.getAuthorFirstName());
                if (result == 0){
                    result = this.title.compareTo(other.getTitle());
                }
            }
            return result;
        }

    }
