package assignment3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Nick Pierre on 10/11/2016.
 */
public class CustomMenu extends Application {

    //
    private PageContent[] pageContents = new PageContent[] {
            new PageContent("Insertion-Sort",
                    "Insertion sort is a simple sorting algorithm that builds the final sorted array " +
                    "(or list) one item at a time.It is much less efficient on large lists than more " +
                    "algorithms such as quicksort, heapsort, or merge sort. " +
                    "However, insertion sort provides several advantages:\n" +
                    "Simple implementation: Bentley shows a three-line C version, and a five-line optimized version\n" +
                    "Efficient for (quite) small data sets, much like other quadratic sorting algorithms\n" +
                    "More efficient in practice than most other simple quadratic (i.e., O(n2)) algorithms " +
                    "such as selection sort or bubble sort\n" +
                    "Adaptive, i.e., efficient for data sets that are already substantially sorted: the time " +
                    "complexity is O(nk) when each element in the input is no more than k places away from its sorted position\n" +
                    "Stable; i.e., does not change the relative order of elements with equal keys\n" +
                    "In-place; i.e., only requires a constant amount O(1) of additional memory space\n" +
                    "Online; i.e., can sort a list as it receives it", "O(n^2"),
            new PageContent("Selection Sort", "In computer science, selection sort is a sorting algorithm, " +
                    "specifically an in-place comparison sort. It has O(n2) time complexity, making it inefficient " +
                    "on large lists, and generally performs worse than the similar insertion sort. Selection sort is" +
                    " noted for its simplicity, and it has performance advantages over more complicated algorithms " +
                    "in certain situations, particularly where auxiliary memory is limited.\n" +
                    "\nThe algorithm divides the input list into two parts: the sublist of items already sorted," +
                    " which is built up from left to right at the front (left) of the list, and the sublist of items" +
                    " remaining to be sorted that occupy the rest of the list. Initially, the sorted sublist is " +
                    "empty and the unsorted sublist is the entire input list. The algorithm proceeds by finding " +
                    "the smallest (or largest, depending on sorting order) element in the unsorted sublist, " +
                    "exchanging (swapping) it with the leftmost unsorted element (putting it in sorted order), " +
                    "and moving the sublist boundaries one element to the right.", "O(n^2)"),
            new PageContent("Merge-Sort", "In computer science, merge sort (also commonly spelled mergesort) is an " +
                    "efficient, general-purpose, comparison-based sorting algorithm. Most implementations produce a " +
                    "stable sort, which means that the implementation preserves the input order of equal elements in" +
                    " the sorted output. Mergesort is a divide and conquer algorithm that was invented by John von " +
                    "Neumann in 1945.[1] A detailed description and analysis of bottom-up mergesort appeared in a" +
                    " report by Goldstine and Neumann as early as 1948" , "O(nLogn"),
            new PageContent("Quick-Sort", "Quicksort (sometimes called partition-exchange sort) is an efficient " +
                    "sorting algorithm, serving as a systematic method for placing the elements of an array in order." +
                    " Developed by Tony Hoare in 1959,[1] with his work published in 1961,[2] it is still a commonly" +
                    " used algorithm for sorting. When implemented well, it can be about two or three times faster " +
                    "than its main competitors, merge sort and heapsort.[3]\n" +
                    "\nQuicksort is a comparison sort, meaning that it can sort items of any type for which a " +
                    "\"less-than\" relation (formally, a total order) is defined. In efficient implementations it is" +
                    " not a stable sort, meaning that the relative order of equal sort items is not preserved. " +
                    "Quicksort can operate in-place on an array, requiring small additional amounts of memory to" +
                    " perform the sorting.\n" +
                    "\nMathematical analysis of quicksort shows that, on average, the algorithm takes O(n log n) " +
                    "comparisons to sort n items. In the worst case, it makes O(n2) comparisons, " +
                    "though this behavior is rare.", "O(n^2)")
    };
    @Override
    public void start(Stage primaryStage) {
        VBox menuVBox = new VBox();

        Scene scene = new Scene(menuVBox, 400, 450);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Custom Menu");
        primaryStage.show();
    }

    class PageContent {
        String alorithmName, description, runTime, imageURL;

        PageContent(String algorithmName, String description, String runTime) {
            this.alorithmName = algorithmName;
            this.description = description;
            this.runTime = runTime;
            imageURL = "assignment3/sortImages/" + algorithmName + ".gif";
        }
    }
}
