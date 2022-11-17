package uz.b25.stream_api;

import uz.b25.entity.Student;

import java.util.*;
import java.util.stream.Collectors;

public class App3 {
    static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student("Shoxrux", 18, "Navoiy"));
        studentList.add(new Student("Obid", 19, "Jizzax", 3));
        studentList.add(new Student("Mirabbos", 22, "Fergana"));
        studentList.add(new Student("O'ktam", 18, "Fergana", 2));
        studentList.add(new Student("Abbos", 20, "Andijan", 3));
        studentList.add(new Student("Sarvar", 21, "Fergana", 4));
        studentList.add(new Student("Muhammad", 18, "Navoiy", 2));

        List<String> list = List.of("english", "uzbek", "russian",
                "turkish", "arabic", "spanish");

        for (int i = 0; i < 20; i++) {
            int studentIndex = new Random().nextInt(studentList.size());
            int languageIndex = new Random().nextInt(list.size());

            Student student = studentList.get(studentIndex);
            String language = list.get(languageIndex);

            if(!student.getLanguages().contains(language)){
                student.getLanguages().add(language);
            }
        }
    }


    public static void main(String[] args) {


        studentList.forEach(System.out::println);

        System.out.println();

        Optional<Student> studentOptional = studentList.stream()
                .max((st1, st2) -> st1.getAge() - st2.getAge());

        if (studentOptional.isPresent()) {
            int age = studentOptional.get().getAge();
            System.out.println("age = " + age);
        }

        Integer maxAge = studentList.stream()
                .map(Student::getAge)
                .max(Integer::compareTo)
                .orElse(null);
        System.out.println("maxAge = " + maxAge);

        System.out.println();

        studentList.stream()
                .filter(student -> student.getCourse()==3)
                .flatMap(student -> student.getLanguages().stream())
                .distinct()
                .forEach(System.out::println);

        System.out.println();

        Map<String, List<Student>> map = studentList.stream()
                .collect(Collectors.groupingBy(Student::getRegion));

        for (String region : map.keySet()) {
            List<Student> studentList = map.get(region);
            System.out.println("\nregion = " + region);
            studentList.forEach(System.out::println);
        }
    }
}
