package com.airhacks.upload.boundary;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/upload")
public class UploadResource {

	private final Logger m_Log = Logger.getLogger("UploadResource");

	@POST
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
	public Response post(@FormDataParam("image") InputStream fileInputStream,
			@FormDataParam("image") FormDataContentDisposition d) {

		m_Log.log(Level.INFO, "Upload request of file: " + d.getFileName());

		BufferedImage image = null;
		try {
			image = ImageIO.read(fileInputStream);
		} catch (IOException ioe) {
			m_Log.log(Level.WARNING, "File is no image!", ioe);
			return Response.status(500, d.getFileName() + " is no image: " + ioe.getMessage()).build();
		}

		m_Log.log(Level.INFO, "Image has resolution " + image.getWidth() + "x" + image.getHeight() + ".");

		return Response.ok().build();
	}

}
