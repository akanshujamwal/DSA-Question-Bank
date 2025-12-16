import java.util.HashMap;

/**
 * Given a date string in the form Day Month Year, where:
 * 
 * Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
 * Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
 * "Sep", "Oct", "Nov", "Dec"}.
 * Year is in the range [1900, 2100].
 * Convert the date string to the format YYYY-MM-DD, where:
 * 
 * YYYY denotes the 4 digit year.
 * MM denotes the 2 digit month.
 * DD denotes the 2 digit day.
 * 
 * 
 * Example 1:
 * 
 * Input: date = "20th Oct 2052"
 * Output: "2052-10-20"
 * Example 2:
 * 
 * Input: date = "6th Jun 1933"
 * Output: "1933-06-06"
 * Example 3:
 * 
 * Input: date = "26th May 1960"
 * Output: "1960-05-26"
 * 
 * 
 * Constraints:
 * 
 * The given dates are guaranteed to be valid, so no error handling is
 * necessary.
 */
class Solution {
    public String reformatDate(String date) {
        String[] chunks = date.split(" ");
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> hm = new HashMap<>();
        hm.put("Jan", "01");
        hm.put("Feb", "02");
        hm.put("Mar", "03");
        hm.put("Apr", "04");
        hm.put("May", "05");
        hm.put("Jun", "06");
        hm.put("Jul", "07");
        hm.put("Aug", "08");
        hm.put("Sep", "09");
        hm.put("Oct", "10");
        hm.put("Nov", "11");
        hm.put("Dec", "12");

        sb.append(chunks[2] + "-");
        sb.append(hm.get(chunks[1])).append("-");
        String dnum = chunks[0].substring(0, chunks[0].length() - 2);
        sb.append(dnum.length() < 2 ? "0" + dnum : dnum);
        return sb.toString();
    }
}