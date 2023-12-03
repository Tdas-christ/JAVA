import java.util.Scanner;

class Performance {
    int[] mark;

    public Performance() 
    {
        mark = new int[10]; // The array 'marks' stores the marks of 10 students
    }

    // Method to read marks into the array
    public void readMarks() 
    {
        Scanner sc = new Scanner(System.in);
        int i;
        System.out.println("Enter the marks of 10 students:");
        for (i = 0; i < 10; i++) {
            mark[i] = sc.nextInt();
        }

        sc.close();
    }

    // Method to return the highest mark scored in the class
    public int highestMark() 
    {
        int i, max = mark[0];
        for (i = 1; i < mark.length; i++) {
            if (mark[i] > max) {
                max = mark[i];
            }
        }
        return max;
    }

    // Method to return the least mark scored in the class
    public int leastMark() 
    {
        int i, min = mark[0];
        for (i = 1; i < mark.length; i++) {
            if (mark[i] < min) {
                min = mark[i];
            }
        }
        return min;
    }

    // Method to return the mode
    public int getMode() 
    {
        int i, j, currelement, currfreq;
        int mode = mark[0];
        int maxfreq = 1;

        for (i = 0; i < mark.length; i++) {
            currelement = mark[i];
            currfreq = 1;

            for (j = i + 1; j < mark.length; j++) {
                if (mark[j] == currelement) {
                    currfreq++;
                }
            }

            if (currfreq > maxfreq || (currfreq == maxfreq && currelement > mode)) {
                mode = currelement;
                maxfreq = currfreq;
            }
        }

        return mode;
    }

    // Method to return the frequency at mode
    public int getFreqAtMode() {
        int mode = getMode();
        int i, freq = 0;

        for (i = 0; i < mark.length; i++) {
            if (mark[i] == mode) {
                freq++;
            }
        }

        return freq;
    }

    // Method to display the results
    public void display() {
        System.out.println("Highest Mark: " + highestMark());
        System.out.println("Least Mark: " + leastMark());
        System.out.println("Mode: " + getMode());
        System.out.println("Mode Frequency: " + getFreqAtMode());
    }

    public static void main(String[] args) {
        Performance p = new Performance();
        p.readMarks();
        p.display();
    }
}

