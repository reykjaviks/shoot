# Build

FROM node:17-alpine AS builder
WORKDIR /builder
COPY package.json ./
COPY package-lock.json ./
RUN npm install
COPY . .
RUN npm run build
RUN ls -a

# Run

FROM nginx:stable
COPY --from=builder /builder/dist /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
