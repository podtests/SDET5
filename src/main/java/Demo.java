public class Demo {

    public static void main(String[] args) {
        String itemPath = "//a/span[text()='%s']";
        String item = "Nike air zoom pegasus 35";
        itemPath = String.format(itemPath, item);
        System.out.println(itemPath);
    }
}
