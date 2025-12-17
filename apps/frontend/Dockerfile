# Build Stage (Node.js)
FROM node:20 AS build

# Set working directory
WORKDIR /app

# Copy frontend static files (adjust if your frontend has a build process)
COPY apps/frontend/index.html /app/build/index.html

# Run Stage (Use Nginx as the web server)
FROM nginx:alpine

# Copy static content to the default Nginx location
COPY --from=build /app/build /usr/share/nginx/html

# Expose port 80 for HTTP
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]