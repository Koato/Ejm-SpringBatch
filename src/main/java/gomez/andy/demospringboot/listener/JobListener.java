package gomez.andy.demospringboot.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import gomez.andy.demospringboot.model.Persona;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JobListener extends JobExecutionListenerSupport {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JobListener(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("Finalizo el job!!!");
			log.warn("Verificar los resultados...");

			jdbcTemplate
					.query("SELECT nombre, apellido, telefono FROM persona",
							(rs, row) -> new Persona(rs.getString(1), rs.getString(2), rs.getString(3)))
					.forEach(persona -> log.info("Registro: " + persona));
		}
	}
}
