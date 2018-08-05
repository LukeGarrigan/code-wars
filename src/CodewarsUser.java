import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CodewarsUser {


    public static void main(String[] args) {


    }


    public static class User {

        int rank = -8;
        int progress = 0;
        int difference;

        public void incProgress(int rankOfActivity) {
            if (this.rank < -8) {
                this.rank = -8;
            }
            if (rankOfActivity < -8 || rankOfActivity > 8 || rankOfActivity == 0) {
                throw new IllegalArgumentException();
            }
            if (rank == 8) {
                return;
            } else if (rankOfActivity == rank) {
                this.progress = this.progress + 3;
            } else if (rankOfActivity < this.rank) {
                updateLowerKata(rankOfActivity);
            } else if (rankOfActivity > this.rank) {
                updateHigherKata(rankOfActivity);

            }
            updateCurrentRank();
        }

        private void updateHigherKata(int rankOfActivity) {
            this.difference = 0;
            for (int i = rankOfActivity; i > this.rank; i--) {
                if (i == 0) {
                    continue;
                }
                this.difference++;
            }
            this.progress += 10 * this.difference * this.difference;
        }

        private void updateLowerKata(int rankOfActivity) {
            this.difference = 0;
            for (int i = this.rank; i > rankOfActivity; i--) {
                if (i == 0) {
                    continue;
                }
                this.difference++;
            }
            if (difference == 1) {
                this.progress = this.progress + 1;
            }

        }

        private void updateCurrentRank() {

            if (this.rank == 8) {
                this.progress = 0;
            } else if (this.progress >= 100) {
                this.progress = this.progress - 100;
                this.rank = this.rank + 1;
                if (this.rank == 0) {
                    this.rank = 1;
                }
                updateCurrentRank();
            }

        }

        public int getRank() {
            return rank;
        }

        public int getProgress() {
            return progress;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public void setProgress(int progress) {
            this.progress = progress;
        }

        public int getDifference() {
            return difference;
        }

        public void setDifference(int difference) {
            this.difference = difference;
        }
    }


    public static class UserTests {

        @Test
        public void testFinishActivityOfSameRank() {
            User user = new User();
            user.incProgress(-8);
            assertEquals(3, user.getProgress());
        }


        @Test
        public void testUserLevelUp() {
            User user = new User();
            user.setProgress(98);
            user.incProgress(-8);
            assertEquals(-7, user.getRank());
            assertEquals(1, user.getProgress());
        }


        @Test
        public void testDifferenceWhenGoingThroughZero() {
            User user = new User();
            user.setRank(-1);
            user.incProgress(1);
            assertEquals(1, user.getDifference());
        }


        @Test
        public void testRankEightDoesARankFour() {
            // should receive 160
            User user = new User();
            user.incProgress(-4);
            assertEquals(60, user.getProgress());
            assertEquals(-7, user.getRank());
        }


        @Test
        public void testRankMinusOne() {
            User user = new User();
            user.incProgress(-1);

        }


        @Test
        public void testProgressRankMinusOne() {
            User user = new User();
            user.setRank(1);
            user.incProgress(-1);
            assertEquals(1, user.getProgress());
        }

        @Test
        public void testDontProgress() {
            User user = new User();
            user.setRank(8);

            user.incProgress(8);
            assertEquals(0, user.getProgress());
        }


        @Test
        public void testMaxLevel() {
            User user = new User();
            user.setRank(8);
            user.incProgress(-8);
            assertEquals(0, user.getProgress());

        }

        @Test
        public void testWhenEight() {
            User user = new User();
            user.setRank(8);
            for (int i = -8; i < 8 && i != 0; i++) {
                user.incProgress(i);
                assertEquals(0, user.getProgress());
            }
        }


        @Test
        public void testCompletingOne() {
            User user = new User();
            user.setRank(-20);
            user.incProgress(1);
            assertEquals(-2, user.getRank());
        }


        @Test
        public void testCompletingRankOfOne() {
            User user = new User();
            user.setRank(-7);
            user.incProgress(1);
            assertEquals(-3, user.getRank());
        }


        @Test
        public void testFromRankOne() {
            User user = new User();
            user.setRank(1);
            user.incProgress(1);
            assertEquals(1, user.getRank());
        }

        @Test
        public void testMinusOneAndOne() {
            User user = new User();
            user.setRank(-1);
            user.incProgress(1);
            assertEquals(10, user.getProgress());
        }

        @Test
        public void testRankMinusEightCompletesMinusFour() {
            User user = new User();
            user.incProgress(-4);
            assertEquals(60, user.getProgress());

        }
    }
}
