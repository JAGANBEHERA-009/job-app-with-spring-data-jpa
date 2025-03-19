package  com.telusko.spring_boot_rest.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.spring_boot_rest.model.JobPost;
import com.telusko.spring_boot_rest.repo.JobRepo;

@Service
public class JobService {
	
	// ArrayList to store JobPost objects
	@Autowired
	private JobRepo repo;
	
	                          //DTO object 
	public void addJob(JobPost jobPost) {
		repo.save(jobPost);	
	}
	
	public List<JobPost> getAllJobs(){
		return repo.findAll();
		
	}

	public JobPost getJob(int postId) {
		// TODO Auto-generated method stub
		
		return  repo.findById(postId).orElse(new JobPost());
		
		
	}

	public void updateJob(JobPost jobPost) {
		// TODO Auto-generated method stub
		
		 repo.save(jobPost);
	}

	public void deleteJob(int postId) {
		repo.deleteById(postId);
		// TODO Auto-generated method stub
		
	}

	public void load() {
		// TODO Auto-generated method stub
		 List<JobPost> jobs = new ArrayList<>(Arrays.asList(

		            new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
		                    List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),


		            new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
		                    List.of("HTML", "CSS", "JavaScript", "React")),


		            new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
		                    List.of("Python", "Machine Learning", "Data Analysis")),


		            new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
		                    List.of("Networking", "Cisco", "Routing", "Switching")),


		            new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
		                    List.of("iOS Development", "Android Development", "Mobile App"))
		    ));
		 repo.saveAll(jobs);
		
	}

	public List<JobPost> search(String keyword) {
		
		// TODO Auto-generated method stub
		//using same keyword twice bcz this method needs two parameter atleast
		return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
	}
	

}
