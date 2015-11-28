import java.util.*;

public class radix {

    public radix() {

        return;
    }

    public static int[] lsdRadixSort(int[] tlist) {

        List<Integer> intermediates;
        int[] limits = getLimits(tlist);
        tlist = rescale(tlist, limits[1]);

        for (int px = 1; px <= limits[2]; ++px) {
            @SuppressWarnings("unchecked")
            Queue<Integer> bukits[] = new Queue[10];
            for (int ix = 0; ix < tlist.length; ++ix) {
                int cval = tlist[ix];
                int digit = (int) (cval / Math.pow(10, px - 1) % 10);
                if (bukits[digit] == null) {
                    bukits[digit] = new LinkedList();
                }
                bukits[digit].add(cval);
            }

            intermediates = new ArrayList();
            for (int bi = 0; bi < 10; ++bi) {
                if (bukits[bi] != null) {
                    while (bukits[bi].size() > 0) {
                        int nextd;
                        nextd = bukits[bi].poll();
                        intermediates.add(nextd);
                    }
                }
            }

            for (int iw = 0; iw < intermediates.size(); ++iw) {
                tlist[iw] = intermediates.get(iw);
            }
        }

        tlist = rescale(tlist, -limits[1]);

        return tlist;
    }

    public static int[] rescale(int[] arry, int delta) {

        for (int ix = 0; ix < arry.length; ++ix) {
            arry[ix] -= delta;
        }

        return arry;
    }

    private static int[] getLimits(int[] tlist) {

        int[] lims = new int[3];

        for (int i_ = 0; i_ < tlist.length; ++i_) {
            lims[0] = Math.max(lims[0], tlist[i_]);
            lims[1] = Math.min(lims[1], tlist[i_]);
        }
        lims[2] = (int) Math.ceil(Math.log10(lims[0] - lims[1]));

        return lims;
    }

    public static void runSample(int[] lists) {

        Random random = new Random();
        int[] n = new int[1];

        for( int i = 0 ; i < n.length ; i++ ) {
            for ( int i1 = 0 ; i1 < n.length ; i1++ ) {
                n[i1] = random.nextInt(255);
            }
        }

        long etime;
        lsdRadixSort(lists); // do one pass to set up environment to remove it from timings
        System.out.println(array2list(lists));
        etime = System.nanoTime();
        lists = lsdRadixSort(lists);
        etime = System.nanoTime() - etime;
        System.out.println(array2list(lists));
        System.out.printf("Elapsed time: %fs%n", ((double) etime / 1000000000.0));
        System.out.println();


        return;
    }

    private static List<Integer> array2list(int[] arry) {

        List<Integer> target = new ArrayList(arry.length);

        for (Integer iv : arry) {
            target.add(iv);
        }

        return target;
    }

    public static void Main(String[] args) {

        runSample(lists);

        return;
    }
}