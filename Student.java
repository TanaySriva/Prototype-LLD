package Prototype;

public class Student implements Prototype<Student>{
    private String name;
    private int age;
    private String batchId;
    private String batchName;

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setBatchId(String batchId){
        this.batchId = batchId;
    }
    public void setBatchName(String batchName){
        this.batchName = batchName;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getBatchId(){
        return batchId;
    }
    public String getBatchName(){
        return batchName;
    }
    public Student copy(){
        //private members can also be accessed
        Student st = new Student();
        st.name = this.name;
        st.age = this.age;
        st.batchName = this.batchName;
        st.batchId = this.batchId;
        return st;
    }
}
