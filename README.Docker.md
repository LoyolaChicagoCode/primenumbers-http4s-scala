# Docker Deployment Guide

This project has been converted from Procfile-based deployment to Docker-based containerized deployment.

## Building the Docker Image

Build the Docker image using:

```bash
docker build -t primenumbers-http4s-scala:latest .
```

## Running the Container

### Using Docker directly

Run the container with:

```bash
docker run -d -p 8080:8080 --name primenumbers primenumbers-http4s-scala:latest
```

To run on a different port:

```bash
docker run -d -p 3000:3000 -e PORT=3000 --name primenumbers primenumbers-http4s-scala:latest
```

### Using Docker Compose

Start the application with:

```bash
docker-compose up -d
```

Stop the application:

```bash
docker-compose down
```

View logs:

```bash
docker-compose logs -f
```

## Container Management

### Stop the container
```bash
docker stop primenumbers
```

### Start the container
```bash
docker start primenumbers
```

### Remove the container
```bash
docker rm primenumbers
```

### View logs
```bash
docker logs -f primenumbers
```

## Testing the Application

Once the container is running, test the application:

```bash
curl http://localhost:8080/
```

## Deployment Options

### Cloud Platforms

This Docker container can be deployed to various cloud platforms:

- **AWS**: Elastic Container Service (ECS), Elastic Kubernetes Service (EKS), or App Runner
- **Google Cloud**: Cloud Run, Google Kubernetes Engine (GKE), or Compute Engine
- **Azure**: Container Instances, Azure Kubernetes Service (AKS), or App Service
- **DigitalOcean**: App Platform or Kubernetes
- **Heroku**: Container Registry and Runtime

### Example: Heroku Container Deployment

```bash
# Login to Heroku Container Registry
heroku container:login

# Create a Heroku app (if not already created)
heroku create your-app-name

# Build and push the image
heroku container:push web -a your-app-name

# Release the image
heroku container:release web -a your-app-name

# Open the app
heroku open -a your-app-name
```

## Environment Variables

- `PORT`: The port the application listens on (default: 8080)

## Notes

- The container runs as a non-root user (appuser) for security
- Health checks are configured in docker-compose.yml
- The image uses a multi-stage build to minimize the final image size
- Java 17 JRE is used for the runtime environment
