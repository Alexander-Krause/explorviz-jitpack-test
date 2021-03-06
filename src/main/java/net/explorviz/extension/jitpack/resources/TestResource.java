package net.explorviz.extension.jitpack.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.svenjacobs.loremipsum.LoremIpsum;
import net.explorviz.extension.jitpack.model.DummyModel;
import net.explorviz.extension.jitpack.model.SubDummyModel;

// @Secured
// Add the "Secured" annotation to enable authentication

@Path("/testalex")
public class TestResource {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public DummyModel getModel() {
		final SubDummyModel subDummy = new SubDummyModel(10);
		return new DummyModel("myDummy", subDummy);
	}

	@GET
	@Path("/show")
	public String show() {
		// Note the dependency in the respective build.gradle
		final LoremIpsum loremIpsum = new LoremIpsum();

		return "Hi from dummy extension: " + loremIpsum.getParagraphs(1);
	}
}