package f_builder;

public class Run {

	public static void main(String[] args) {
		Book book = new Book.Builder()
				.title("해리포터")
				.author("포터해리")
				.price(90000)
				.page(300)
				.build();
		
		System.out.println(book);
	}

}
