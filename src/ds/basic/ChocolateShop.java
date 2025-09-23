package ds.basic;

import java.util.*;

public class ChocolateShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        int n = scanner.nextInt(); // Number of candy types
        int[] prices = new int[n]; // Coupons needed for each candy type

        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        int k = scanner.nextInt(); // Total gift coupons Henry has

        // Priority Queue to sort by candy price (min-heap)
        PriorityQueue<Candy> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        
        PriorityQueue<Candy> pq1 = new PriorityQueue<>(Comparator.comparingInt(Candy::getCost));

        // Add each candy type to the queue with its max allowable count
        for (int i = 0; i < n; i++) {
            int maxCount = n - i; // 1st candy: N times, 2nd: N-1, ..., Nth: 1 time
            pq.offer(new Candy(prices[i], maxCount));
        }

        int candiesBought = 0;

        // Greedy: always try to buy cheapest available candy
        while (!pq.isEmpty() && k > 0) {
            Candy c = pq.poll();

            // Max candies of this type that can be bought with remaining coupons
            int canBuy = Math.min(c.maxCount, k / c.cost);
            candiesBought += canBuy;
            k -= canBuy * c.cost;
        }

        System.out.println(candiesBought);
    }

    // Candy class to represent price and max allowed purchase count
    static class Candy {
        int cost;
        int maxCount;

        /**
		 * @return the cost
		 */
		public int getCost() {
			return cost;
		}

		/**
		 * @param cost the cost to set
		 */
		public void setCost(int cost) {
			this.cost = cost;
		}

		/**
		 * @return the maxCount
		 */
		public int getMaxCount() {
			return maxCount;
		}

		/**
		 * @param maxCount the maxCount to set
		 */
		public void setMaxCount(int maxCount) {
			this.maxCount = maxCount;
		}

		Candy(int cost, int maxCount) {
            this.cost = cost;
            this.maxCount = maxCount;
        }
    }
}
