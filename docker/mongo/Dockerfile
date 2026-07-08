FROM mongo:8.0

RUN apt-get update && \
    apt-get install -y gettext-base && \
    rm -rf /var/lib/apt/lists/*

COPY init.sh /init.sh
COPY init.js.template /init.js.template

RUN chmod +x /init.sh

ENTRYPOINT ["/init.sh"]