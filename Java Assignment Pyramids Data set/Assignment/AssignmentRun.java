package Assignment;

import java.util.List;

public class AssignmentRun {

    public static void main(String[] args) {

        PyramidCSVDAO pDAO = new PyramidCSVDAO();
        List<Pyramid> pyramids = pDAO.readFromCSV("pyramids.csv");
        int count = 0;
        for (Pyramid p : pyramids) {
            count++;
            System.out.println(count + ": " + p.info());
        }
    }

}
