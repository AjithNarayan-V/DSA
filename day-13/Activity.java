import java.util.Arrays;
import java.util.Scanner;

class Activity {

    public int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        // Step 1: Combine start & finish into 2D array
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = start[i];   // start
            arr[i][1] = finish[i];  // finish
        }
        // Step 2: Sort by finish time
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        // Step 3: Select first activity
        int count = 1;
        int lastFinish = arr[0][1];
        // Step 4: Check remaining
        for (int i = 1; i < n; i++) {
            if (arr[i][0] > lastFinish) {   // STRICT condition
                count++;
                lastFinish = arr[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of activities: ");
        int n = scanner.nextInt();
        
        int[] start = new int[n];
        int[] finish = new int[n];
        
        System.out.println("Enter start times:");
        for (int i = 0; i < n; i++) {
            start[i] = scanner.nextInt();
        }
        
        System.out.println("Enter finish times:");
        for (int i = 0; i < n; i++) {
            finish[i] = scanner.nextInt();
        }
        
        Activity activity = new Activity();
        int maxActivities = activity.activitySelection(start, finish);
        
        System.out.println("Maximum number of activities: " + maxActivities);
        
        scanner.close();
    }
}