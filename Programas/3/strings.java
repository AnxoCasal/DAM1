public class strings {
    public static void main(String[] args) {
        String ejem = "Jar Jar Bin is the Big Boss";
        String ejem2 = ejem.toUpperCase();
        String ejem3 = ejem.substring(3,8);

        System.out.println(ejem.length());

        System.out.println(ejem.charAt(0));
        System.out.println(ejem.charAt(ejem.length()-1));
        //System.out.println(ejem.charAt(100));

        System.out.println(ejem.equals(ejem2));
        System.out.println(ejem.equalsIgnoreCase(ejem2));

        System.out.println(ejem.toLowerCase());
        
        System.out.println(ejem.endsWith("Boss"));
        System.out.println(ejem.endsWith("Jar"));

        System.out.println(ejem.indexOf("Jar"));
        System.out.println(ejem.lastIndexOf("Jar"));

        System.out.println(ejem3.trim());

        for(String item : ejem.split(" ")){
            System.out.println(item);
        }
    }
}
