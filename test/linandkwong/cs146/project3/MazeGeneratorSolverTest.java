package linandkwong.cs146.project3;

import org.junit.Test;

import java.io.*;
import java.util.Random;

import static org.junit.Assert.*;

public class MazeGeneratorSolverTest {

    @Test
    public void solveMaze() {
        MazeFileReader readMaze = new MazeFileReader();
        MazeGeneratorSolver testMaze = new MazeGeneratorSolver(readMaze.mazeFileReader(new File("sampleInputs/customTestMaze.txt")));
        String fileName = "data/testMazeKey.txt";
        testMaze.solveMaze(fileName);
        assertTrue(new File(fileName).exists());
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(fileName));
            BufferedReader br2 = new BufferedReader(new FileReader("customTestMazeKey/testMazeKey.txt"));
            String line1 = br1.readLine();
            String line2 = br2.readLine();
            while (line1 != null && line2 != null) {
                assertTrue(line1.contains(line2));
                line1 = br1.readLine();
                line2 = br2.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}