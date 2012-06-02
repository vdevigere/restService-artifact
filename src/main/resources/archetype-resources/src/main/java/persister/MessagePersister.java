package ${package}.persister;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.google.inject.persist.Transactional;

public class MessagePersister {

	@Inject
	EntityManager em;

	@Transactional
	public Integer save(String message) {
		Message m = new Message(message);
		em.persist(m);
		return m.id;
	}

	@Transactional
	public void update(Integer id, String newMessage) {
		Message message = getById(id);
		message.setMessage(newMessage);
		em.persist(message);
	}

	public Message getById(Integer id) {
		return em.find(Message.class, id);
	}

	@Transactional
	public void deleteById(Integer id) {
		em.remove(getById(id));
	}

}
