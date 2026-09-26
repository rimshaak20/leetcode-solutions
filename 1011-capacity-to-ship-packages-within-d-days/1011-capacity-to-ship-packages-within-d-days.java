class Solution {
    private boolean canShip(int[] weights, int days, int capacity) {
        int usedDays = 1;
        int currentLoad = 0;

        for (int weight : weights) {
            // Start a new day when the next package
            // would cross the ship capacity.
            if (currentLoad + weight > capacity) {
                usedDays++;

                // The current package begins the next day
                // because package order cannot be changed.
                currentLoad = weight;
            } else {
                // The package fits today, so keep it
                // in the current day's load.
                currentLoad += weight;
            }
        }

        // This capacity works if shipping finishes
        // within the allowed number of days.
        return usedDays <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        // This stores the smallest valid capacity found so far.
        int answer = high;

        while (low <= high) {
            // mid is the capacity currently being tested.
            int mid = low + (high - low) / 2;

            // If mid works, try to find an even smaller valid capacity.
            if (canShip(weights, days, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                // If mid does not work, more capacity is required.
                low = mid + 1;
            }
        }

        return answer;
    }
}
