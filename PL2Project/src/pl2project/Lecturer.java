package pl2project;

import java.io.*;
import java.util.*;

/**
 *
 * @author Ali Abdulhady
 */
public class Lecturer extends SystemUser implements Serializable {

    /**
     *
     * @author pc
     */
    public static ArrayList<Lecturer> lecturers = new ArrayList<>();
    private static ArrayList<Subject> teachedSubjects = new ArrayList<>();
    public static ArrayList<Student>reports = new ArrayList<>();
    HashMap<Integer, Double> map = new HashMap<>();
    HashMap<Integer, Integer> student_degrees = new HashMap<>();

    Scanner sc = new Scanner(System.in);
    BinaryManager fmanager=new BinaryManager();

//    public static ArrayList<String> getTeached_subjects() {
//        return teached_subjects;
//    }
//
//    public static void setTeached_subjects(Lecturer) {
//        Lecturer.teached_subjects.add(e)
 
//    }
    private final String lecturerFileName = "lecturer.bin";
    private final String reportsfilename = "reports.bin";
    private final String subjectsFileName="teachedSubjects.bin";
    private final String exams = "exams.bin";

    public Lecturer() {
    }

    public Lecturer(int id, String email, String username, String password, String fname, String lname) {
        super(id, email, username, password, fname, lname);

    }
    @Override
    public Lecturer login(String username,String password){
        loadAUX();
        for(Lecturer x:lecturers){
            if(username.equals(x.UserName)&&password.equals(x.PassWord))
                    return x;
                }
        return null;
    }

        private void loadSubjects(){
           teachedSubjects=(ArrayList < Subject >)fmanager.read(subjectsFileName);
        }
        private boolean updateSubjects(){
            return fmanager.write(subjectsFileName,teachedSubjects);
        }
        
           public  boolean SetTeachedSubjects(Subject e) {
        loadSubjects();
        teachedSubjects.add(e);
        return updateSubjects();
        
        
    }
    public boolean addlecturer() {
        loadAUX();
        lecturers.add(this);
        return updateAUX();
    }

    @Override
    public String toString() {
        return "First name: " + FName + " Last name: " + Lname + " ID : " + ID + " UserName: " + UserName + " Password: " + PassWord;

    }

    //AUX FUNCTIONS SECTION//
    //WE USE IT IN OTHER FUNCTIONS AND DONT MAKE BODY OF FUNCTION SO BIG//
    private void loadAUX() {
        lecturers = (ArrayList<Lecturer>) fmanager.read(lecturerFileName);
//        Student s = (Student) lecturers.get(10);
    }

    private int getterAUX(int id) {
        for (int i = 0; i < lecturers.size(); i++) {
            if (lecturers.get(i).getID() == id) {
                return i;

            }
        }
        return 0;
    }

    private boolean updateAUX() {
        return fmanager.write(lecturerFileName, lecturers);
    }

    private String getDataAUX() {
        return this.ID + "~~" + this.FName + "~~" + this.Lname + "~~" + this.UserName + "~~" + this.PassWord + "~~" + Lecturer.teachedSubjects + "~~";

    }

        public Student student_reports(Student x)
    {
        map.put(x.ID, x.getDegree());
        
      
        try
           {
         try (FileOutputStream fos = new FileOutputStream("reports.bin"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
             oos.writeObject(map);
         }
                  System.out.printf("Serialized HashMap data is saved in reports.bin");
           }catch(IOException ioe)
            {
            }
        return x;
        
        
    }

    //END OF AUX FUNCTIONS SECTION//
    public boolean searchlecturer(int id){
        loadAUX();
        int index=getterAUX(id);
        return (index>0);
        
        
    }
    public String list_lecturerdata() {
        loadAUX();
        String x = "\n";
        for (Lecturer z : lecturers) {
            x = x + z.toString();
        }
        return x;
    }

    public boolean update_lecturerdata(int oid, Lecturer l) {
        loadAUX();
        int ind = getterAUX(oid);
        if (ind >= 0) {
            lecturers.set(ind, l);
            updateAUX();
            return true;
        }
        return false;
    }

    public boolean delete_lecturerdata(int id) {
        loadAUX();
        int ind = getterAUX(id);
        lecturers.remove(ind);
        updateAUX();
        return true;
    }

    public void addexam(Subject x , Exam e ) {
        e.setAcess_code(x.getAccessCode());
        int mcq_num =0;
        int tfq_num=0;
        int matchq_num=0;
        sc.nextInt(mcq_num);
        sc.nextInt(tfq_num);
        sc.nextInt(matchq_num);
        for(int i =0 ; i<mcq_num ; i++)
        {
            MCQ a = new MCQ() ;
            a.setMCQ(e, sc.next(),sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble());
            e.questions.add(a);
        }
         for(int i =0 ; i<tfq_num ; i++)
        {
            TFQ a = new TFQ() ;
            a.setTFQ(e, sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble());
            e.questions.add(a);
        }
        
         for(int i =0 ; i<matchq_num ; i++)
        {
            MatchQ a = new MatchQ() ;
            a.setMatchQ(e, sc.next() ,  sc.next(),  sc.next(), sc.nextDouble());
            e.questions.add(a);
        }
        
    }

    /*void student_reports()
    {
        
    }*/
    public void delete_exam(int id, Exam l) {
        l = null;
    }

    

    public void list_exams(Exam l) {
        for(int i =0 ; i< l.added_q ; i++){
            System.out.println(l.questions.get(i).Q);
        }
    }

    /* public void Assign_studnet_degree(student x , subject y )
    {
        
     
    }
     */
   
}
