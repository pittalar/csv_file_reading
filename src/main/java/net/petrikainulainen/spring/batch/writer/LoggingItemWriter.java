package net.petrikainulainen.spring.batch.writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import net.petrikainulainen.spring.batch.dto.StudentDTO;
import net.petrikainulainen.spring.batch.entity.StudentEntity;
import net.petrikainulainen.spring.batch.repo.StudentRepository;

import java.util.List;

/**
 * This {@code ItemWriter} writes the received {@link StudentDTO} objects
 * to a log file. The goal of this component is to help us to demonstrate
 * that our item reader reads the correct information from the CSV file.
 */
public class LoggingItemWriter implements ItemWriter<StudentDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingItemWriter.class);
    
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void write(List<? extends StudentDTO> list) throws Exception {
        LOGGER.info("Writing students: {}", list);
        list.stream().forEach(student -> {
        	StudentEntity entity = new StudentEntity();
        	entity.setEmailAddress(student.getEmailAddress());
        	entity.setName(student.getName());
        	entity.setPurchasedPackage(student.getPurchasedPackage());
        	studentRepository.save(entity);
        });
    }
}
