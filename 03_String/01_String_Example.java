public class StringExample {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("Hello");
        stringBuffer.append(" JAVA");
        System.out.println(stringBuffer + "\n Length => "+stringBuffer.length()+"\n Capacity => "+stringBuffer.capacity());

        StringBuilder stringBuilder = new StringBuilder("Hello");
        stringBuilder.append(" JAVA");
        System.out.println(stringBuilder + "\n Length => "+stringBuilder.length()+"\n Capacity => "+stringBuilder.capacity());
    }
}
    