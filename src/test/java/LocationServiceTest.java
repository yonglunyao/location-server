import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import org.junit.Test;
import wknn.WKNN;

public class LocationServiceTest {
    @Test
    public void test () throws MWException {
        String filename = "1637136597571_6_94_0_r.txt";
        int scan_times = 10;

        Object[] wknnArgs = new Object[2];
        wknnArgs[0] = filename;
        wknnArgs[1] = scan_times;
        WKNN wknn = new WKNN();
        Object[] objArray = (Object[])wknn.wknn(3, wknnArgs);

        MWNumericArray mwFloor = (MWNumericArray) objArray[0];
        double floor = mwFloor.getDouble();

        MWNumericArray mwSouth = (MWNumericArray) objArray[1];
        double south = mwSouth.getDouble();

        MWNumericArray mwEast = (MWNumericArray) objArray[2];
        double east = mwEast.getDouble();

        System.out.println(floor);
        System.out.println(south);
        System.out.println(east);
    }
}
