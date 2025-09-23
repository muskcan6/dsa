class Solution {

    public int compareVersion(String v1, String v2) {
        String[] arr1 = v1.split("\\.");
        String[] arr2 = v2.split("\\.");

        int n = Math.max(arr1.length, arr2.length);

        for (int i = 0; i < n; i++) {
            int vv1 = (i < arr1.length) ? Integer.parseInt(arr1[i]) : 0;
            int vv2 = (i < arr2.length) ? Integer.parseInt(arr2[i]) : 0;

            if (vv1 > vv2) return 1;
            if (vv2 > vv1) return -1;
        }

        return 0;
    }
}
