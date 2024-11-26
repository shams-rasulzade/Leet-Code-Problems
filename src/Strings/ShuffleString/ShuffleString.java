package Strings.ShuffleString;

public class ShuffleString {
    public static String restoreString(String s, int[] indices) {
        char[] shuffle = new char[indices.length];

        for (int i = 0; i < indices.length; i++){
            shuffle[indices[i]] = s.charAt(i);
        }
        return String.valueOf(shuffle);
    }

    public static void main (String[] args){
        String s = "codeleet";
        int[] indices = new int[]{4,5,6,7,0,2,1,3};
        System.out.println(restoreString(s, indices));
    }
}
