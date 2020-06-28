FROM clojure:openjdk-15-tools-deps-alpine as development-stage

## Github christoph-frick/try-shadow-cljs

## docker-compose up build

RUN apk add --update --no-cache nodejs-npm yarn

RUN yarn global add shadow-cljs

WORKDIR /app

COPY package*.json /app/
RUN yarn add react@16.13.1 react-dom@16.13.1

COPY *.edn /app/

RUN clojure -e "(println \"Downloading clojure deps\")"

ENTRYPOINT ["clojure"]


## build stage
# FROM development-stage as build-stage
# RUN yarn build
## production stage
# FROM nginx:1.17.9-alpine as production-stage
# COPY --from=build-stage /app/dist /usr/share/nginx/html
# EXPOSE 80
# CMD ["nginx", "-g", "daemon off;"]
