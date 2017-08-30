package base;

/**
 * Created by shs1329 on 2017/8/29.
 */

public class KMP {
    public static void main(String... args) {
        String parent = "abcdabcdef";
        String child = "abcdef";
        KMP(parent, child);
    }

    private static void KMP(String source, String pattern) {
        //根据要比较的字符串算出数组N
        int[] N = getN(pattern);
        int sourceLength = source.length();
        int patternLength = pattern.length();
        int i = 0;
        while (i <= sourceLength - patternLength) {
            String str = source.substring(i, i + patternLength);//要比较的字符串
            int count = getNext(pattern, str, N);
            if (count == 0) {
                print("KMP：匹配成功");
                break;
            }
            i = i + count;
        }
    }

    /**
     * 得到下一次要移动的次数
     *
     * @param pattern
     * @param str
     * @param N
     * @return 0, 字符串匹配；
     */
    private static int getNext(String pattern, String str, int[] N) {
        int n = pattern.length();
        char value1[] = str.toCharArray();
        char value2[] = pattern.toCharArray();
        int x = 0;
        while (n-- != 0) {
            if (value1[x] != value2[x]) {
                if (x == 0) {
                    return 1;//如果第一个不相同，移动1步
                }
                return x - N[x - 1];//x:第一次出现不同的索引的位置，即j
            }
            x++;
        }
        return 0;
    }

    private static int[] getN(String pattern) {
        char[] pat = pattern.toCharArray();
        int j = pattern.length() - 1;
        int[] N = new int[j + 1];
        for (int i = j; i >= 2; i--) {
            N[i - 1] = getK(i, pat);
        }
        return N;
    }

    /**
     * 走K步
     * @param i
     * @param pattern
     * @return
     */
    private static int getK(int i, char[] pattern) {
        int x = i - 2;
        int y = 1;
        //从start到y的值与x到end的值相同。
        while (x >= 0 && compare(pattern, 0, x, y)) {
            x--;
            y++;
        }
        return x + 1;
    }

    private static boolean compare(char[] pat, int start, int length, int end) {
        int n = length - start + 1;
        while (n-- != 0) {
            if (pat[start] != pat[end]) {
                return true;
            }
            start++;
            end++;
        }
        return false;
    }

    public static void print(Object obj) {
        System.out.println(obj);
    }
}
