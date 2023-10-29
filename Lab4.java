import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

public class Lab4 {

    public static void main(String[] args) {
        try {
                EducationalInstitution[] institutions = {
                    new EducationalInstitution("Kyiv Polytechnic Institute", CreateDate(1898, Calendar.SEPTEMBER, 1), "Dmitri Mendeleev", 35000, 170),
                    new EducationalInstitution("Harvard University", CreateDate(1636, Calendar.SEPTEMBER, 8), "The Massachusetts Legislature", 20334, 100),
                    new EducationalInstitution("University of Oxford", CreateDate(1096, Calendar.JANUARY, 1), "Unknown", 24505, 45)
                };

                //by class count Desc
                Arrays.sort(institutions, Comparator.comparing(EducationalInstitution::GetNumberOfClasses).reversed());
                Print(institutions);
                
                System.out.println("==============================================");

                //by year of foundation Desc
                Arrays.sort(institutions, Comparator.comparing(EducationalInstitution::GetDateOfFoundation));
                Print(institutions);
            }    
        catch (Exception e) {
            System.err.println(e);
        }
    }

    private static <T> void Print(T[] array) {
        for (T item : array) {
            System.out.println(item);
        }
    }

    private static Date CreateDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }
}
/**
 * EducationalInstitution represents an educational institution.
 */
class EducationalInstitution {
    private String _name;
    private Date _dateOfFoundation;
    private String _founderName;
    private Integer _maxStudentCapacity;
    private Integer _numberOfClasses;

    /**
     * Constructor to initialize an EducationalInstitution object.
     * @param name The name of the educational institution.
     * @param dateOfFoundation The date of foundation of the educational institution.
     * @param founderName The name of the founder of the educational institution.
     * @param maxStudentCapacity The maximum student capacity of the educational institution.
     * @param numberOfClasses The number of classes in the educational institution.
     */
    public EducationalInstitution(String name, Date dateOfFoundation, String founderName, Integer maxStudentCapacity, Integer numberOfClasses) {
        SetName(name);
        SetDateOfFoundation(dateOfFoundation);
        SetFounderName(founderName);
        SetMaxStudentCapacity(maxStudentCapacity);
        SetNumberOfClasses(numberOfClasses);
    }

    public String GetName() {
        return _name;
    }

    public Date GetDateOfFoundation() {
        return _dateOfFoundation;
    }

    public String GetFounderName() {
        return _founderName;
    }

    public Integer GetMaxStudentCapacity() {
        return _maxStudentCapacity;
    }
    
    public Integer GetNumberOfClasses() {
        return _numberOfClasses;
    }

    private String GetFormattedDateOfFoundation() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(_dateOfFoundation);
        return String.format(
            "%04d-%02d-%02d",
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH) + 1,
            calendar.get(Calendar.DAY_OF_MONTH)
    );
    }

    /**
     * Sets the name of the educational institution.
     * @param name A non-null, non-empty string representing the name.
     * @throws IllegalArgumentException if the name is null or an empty string.
     */
    public void SetName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name must be not null or empty");
        }
        _name = name;
    }

    /**
     * Sets the date of foundation of the educational institution.
     * @param dateOfFoundation A non-null Date object representing the date of foundation.
     * @throws IllegalArgumentException if the date of foundation is null.
     */
    public void SetDateOfFoundation(Date dateOfFoundation) {
        if (dateOfFoundation == null) {
            throw new IllegalArgumentException("Date of Foundation must be not null");
        }
        _dateOfFoundation = dateOfFoundation;
    }

    /**
     * Sets the name of the founder of the educational institution.
     * @param founderName A non-null, non-empty string representing the founder's name.
     * @throws IllegalArgumentException if the founder's name is null or an empty string.
     */
    public void SetFounderName(String founderName) {
        if (founderName == null || founderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Founder Name must be not null or empty");
        }
        _founderName = founderName;
    }

    /**
     * Sets the maximum student capacity of the educational institution.
     * @param maxStudentCapacity A positive integer representing the maximum student capacity.
     * @throws IllegalArgumentException if the maximum student capacity is null or less than 1.
     */
    public void SetMaxStudentCapacity(Integer maxStudentCapacity) {
        if (maxStudentCapacity == null || maxStudentCapacity < 1) {
            throw new IllegalArgumentException("Max Student Capacity must be a positive integer");
        }
        _maxStudentCapacity = maxStudentCapacity;
    }

    /**
     * Sets the number of classes in the educational institution.
     * @param numberOfClasses A positive integer representing the number of classes.
     * @throws IllegalArgumentException if the number of classes is null or less than 1.
     */
    public void SetNumberOfClasses(Integer numberOfClasses) {
        if (numberOfClasses == null || numberOfClasses < 1) {
            throw new IllegalArgumentException("Number of Classes must be a positive integer");
        }
        _numberOfClasses = numberOfClasses;
    }

    /**
     * Calculates the average maximum capacity per class in the educational institution.
     * @return The average maximum capacity per class.
     */
    public double CalculateAverageMaxCapacityPerClass() {
        return (double) _maxStudentCapacity / _numberOfClasses;
    }

    @Override
    public String toString() {
        return "Educational Institute {\n" +
            "  \"name\": \"" + _name + "\",\n" +
            "  \"dateOfFoundation\": \"" + GetFormattedDateOfFoundation() + "\",\n" +
            "  \"founderName\": \"" + _founderName + "\",\n" +
            "  \"maxStudentCapacity\": " + _maxStudentCapacity + ",\n" +
            "  \"numberOfClasses\": " + _numberOfClasses + "\n" +
            "}";
    }
}
