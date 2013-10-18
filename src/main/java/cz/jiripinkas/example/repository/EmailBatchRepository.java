package cz.jiripinkas.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cz.jiripinkas.example.entity.EmailBatch;

public interface EmailBatchRepository extends JpaRepository<EmailBatch, Integer> {

	@Query("select eb from EmailBatch eb left join fetch eb.toEmails where eb.emailBatchId = :id")
	EmailBatch findOneFetch(@Param("id") int id);
}
