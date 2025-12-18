package com.humber.FinalProject1;

import com.humber.FinalProject1.models.Student;
import com.humber.FinalProject1.services.CompanyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalProject1AppApplication implements CommandLineRunner {

    private final CompanyService studentService;

    public FinalProject1AppApplication(CompanyService studentService) {
        this.studentService = studentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FinalProject1AppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello from command line runner!");

        // Saving sample students with className field
        studentService.saveStudent(new Student(1, "Alice Johnson", "alice.johnson@humber.ca", 85, "CPAN-123"));
        studentService.saveStudent(new Student(2, "Bob Smith", "bob.smith@humber.ca", 90, "CPAN-123"));
        studentService.saveStudent(new Student(3, "Carol Davis", "carol.davis@humber.ca", 78, "CPAN-321"));
        studentService.saveStudent(new Student(4, "David Wilson", "david.wilson@humber.ca", 92, "CPAN-321"));
        studentService.saveStudent(new Student(5, "Eve Brown", "eve.brown@humber.ca", 88, "CPAN-123"));
        studentService.saveStudent(new Student(6, "Frank Miller", "frank.miller@humber.ca", 76, "CPAN-321"));
        studentService.saveStudent(new Student(7, "Grace Lee", "grace.lee@humber.ca", 84, "CPAN-123"));
        studentService.saveStudent(new Student(8, "Hank Taylor", "hank.taylor@humber.ca", 91, "CPAN-321"));
        studentService.saveStudent(new Student(9, "Ivy White", "ivy.white@humber.ca", 89, "CPAN-123"));
        studentService.saveStudent(new Student(10, "Jack Harris", "jack.harris@humber.ca", 83, "CPAN-321"));
        studentService.saveStudent(new Student(11, "Kara Clark", "kara.clark@humber.ca", 87, "CPAN-123"));
        studentService.saveStudent(new Student(12, "Liam Lewis", "liam.lewis@humber.ca", 80, "CPAN-321"));
        studentService.saveStudent(new Student(13, "Mia Robinson", "mia.robinson@humber.ca", 93, "CPAN-123"));
        studentService.saveStudent(new Student(14, "Nate Walker", "nate.walker@humber.ca", 82, "CPAN-321"));
        studentService.saveStudent(new Student(15, "Olivia Young", "olivia.young@humber.ca", 79, "CPAN-123"));
        studentService.saveStudent(new Student(16, "Paul King", "paul.king@humber.ca", 77, "CPAN-321"));
        studentService.saveStudent(new Student(17, "Quinn Scott", "quinn.scott@humber.ca", 81, "CPAN-123"));
        studentService.saveStudent(new Student(18, "Rachel Adams", "rachel.adams@humber.ca", 90, "CPAN-321"));
        studentService.saveStudent(new Student(19, "Steve Carter", "steve.carter@humber.ca", 75, "CPAN-123"));
        studentService.saveStudent(new Student(20, "Tina Mitchell", "tina.mitchell@humber.ca", 86, "CPAN-321"));

        // Adding more students with CPAN-104
        studentService.saveStudent(new Student(21, "Ursula Morgan", "ursula.morgan@humber.ca", 78, "CPAN-104"));
        studentService.saveStudent(new Student(22, "Victor Perez", "victor.perez@humber.ca", 84, "CPAN-104"));
        studentService.saveStudent(new Student(23, "Wendy Anderson", "wendy.anderson@humber.ca", 91, "CPAN-104"));
        studentService.saveStudent(new Student(24, "Xander Thompson", "xander.thompson@humber.ca", 89, "CPAN-104"));
        studentService.saveStudent(new Student(25, "Yara Wilson", "yara.wilson@humber.ca", 85, "CPAN-104"));
        studentService.saveStudent(new Student(26, "Zachary Brown", "zachary.brown@humber.ca", 77, "CPAN-104"));

        // Adding additional students with varied class assignments
        studentService.saveStudent(new Student(27, "Amy Miller", "amy.miller@humber.ca", 80, "CPAN-123"));
        studentService.saveStudent(new Student(28, "Brian Scott", "brian.scott@humber.ca", 92, "CPAN-321"));
        studentService.saveStudent(new Student(29, "Catherine Davis", "catherine.davis@humber.ca", 88, "CPAN-123"));
        studentService.saveStudent(new Student(30, "Daniel Jones", "daniel.jones@humber.ca", 74, "CPAN-321"));
        studentService.saveStudent(new Student(31, "Emily Brown", "emily.brown@humber.ca", 81, "CPAN-123"));
        studentService.saveStudent(new Student(32, "Franklin Adams", "franklin.adams@humber.ca", 93, "CPAN-321"));
        studentService.saveStudent(new Student(33, "Georgia Miller", "georgia.miller@humber.ca", 82, "CPAN-123"));
        studentService.saveStudent(new Student(34, "Henry Thompson", "henry.thompson@humber.ca", 77, "CPAN-321"));
        studentService.saveStudent(new Student(35, "Isabella Wilson", "isabella.wilson@humber.ca", 90, "CPAN-123"));
        studentService.saveStudent(new Student(36, "James Taylor", "james.taylor@humber.ca", 85, "CPAN-321"));
        studentService.saveStudent(new Student(37, "Kaitlyn Robinson", "kaitlyn.robinson@humber.ca", 79, "CPAN-123"));
        studentService.saveStudent(new Student(38, "Lucas Harris", "lucas.harris@humber.ca", 88, "CPAN-321"));
        studentService.saveStudent(new Student(39, "Megan Clark", "megan.clark@humber.ca", 86, "CPAN-123"));
        studentService.saveStudent(new Student(40, "Nathan Walker", "nathan.walker@humber.ca", 80, "CPAN-321"));
        studentService.saveStudent(new Student(41, "Olivia Jones", "olivia.jones@humber.ca", 84, "CPAN-123"));
        studentService.saveStudent(new Student(42, "Patrick Young", "patrick.young@humber.ca", 79, "CPAN-321"));
        studentService.saveStudent(new Student(43, "Quincy Brown", "quincy.brown@humber.ca", 90, "CPAN-123"));
        studentService.saveStudent(new Student(44, "Rachel Lewis", "rachel.lewis@humber.ca", 75, "CPAN-321"));
        studentService.saveStudent(new Student(45, "Samuel Adams", "samuel.adams@humber.ca", 87, "CPAN-123"));
        studentService.saveStudent(new Student(46, "Tiffany Green", "tiffany.green@humber.ca", 89, "CPAN-321"));
        studentService.saveStudent(new Student(47, "Ulysses Carter", "ulysses.carter@humber.ca", 92, "CPAN-123"));
        studentService.saveStudent(new Student(48, "Veronica Mitchell", "veronica.mitchell@humber.ca", 80, "CPAN-321"));
        studentService.saveStudent(new Student(49, "William King", "william.king@humber.ca", 81, "CPAN-104"));
        studentService.saveStudent(new Student(50, "Xena Adams", "xena.adams@humber.ca", 84, "CPAN-104"));
    }
}

