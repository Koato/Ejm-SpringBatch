package gomez.andy.demospringboot.processor;

import org.springframework.batch.item.ItemProcessor;

import gomez.andy.demospringboot.model.Persona;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonaItemProcessor implements ItemProcessor<Persona, Persona> {
	@Override
	public Persona process(Persona item) throws Exception {
		String nombre = item.getNombre().toUpperCase();
		String apellido = item.getApellido().toUpperCase();
		String telefono = item.getTelefono().toUpperCase();
		Persona persona = new Persona(nombre, apellido, telefono);
		log.info("Convirtiendo (" + item + ") a (" + persona + ")");
		return persona;
	}
}