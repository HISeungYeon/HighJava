package practice;

public class GenericPrac {

	public static void main(String[] args) {
		MyGeneric<String> gg = new MyGeneric<String>();
		MyGeneric<Integer> ii = new MyGeneric<Integer>();

		gg.setVal("하이요");
		ii.setVal(8080);

		String hi = gg.getVal();
		int a = ii.getVal();

		System.out.println(gg.getVal() + ii.getVal());

	}
}

class NonGeneric {
	private Object val;

	public Object getVal() {
		return val;
	}

	public void setVal(Object val) {
		this.val = val;
	}

}

class MyGeneric<T> {
	private T val;

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}
}