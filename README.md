# jaxrs-upload

Contains a JAX-RS webservice /rest with two methods /ping and /upload. The upload uses a Jersey 2.x FormDataParam to recieve the file. The webservice tries to create an image from the InputStream and just loggs the dimensions of the image to the server.log.

  http://localhost:8080/jaxrs-upload/index.html
  
This is a simple form to input the file that is uploaded to the webservice. 
