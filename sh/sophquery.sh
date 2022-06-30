#/bin/bash

for word in "$@"
do
  curl -s https://dictionaryapi.com/api/v3/references/thesaurus/json/$word?key=5de84fd2-0674-4315-958c-6e509d2f0c74 | jq -r '.[] | select(.fl=="adjective") | .meta | .syns[][]' | grep -v '[^a-z]'
  curl -s https://dictionaryapi.com/api/v3/references/thesaurus/json/$word?key=5de84fd2-0674-4315-958c-6e509d2f0c74 | jq -r '.[] | select(.fl=="adjective") | .meta | .ants[][]' | grep -v '[^a-z]'
done
