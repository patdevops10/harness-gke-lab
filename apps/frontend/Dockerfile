# Build Stage (Simple copy for static files)
FROM node:20 as build
WORKDIR /app
COPY index.html /app/build/index.html 

# Run Stage (Use Nginx as the web server)
FROM nginx:alpine
# Copy static content to the default Nginx location
COPY --from=build /app/build /usr/share/nginx/html
EXPOSE 80 
CMD ["nginx", "-g", "daemon off;"]