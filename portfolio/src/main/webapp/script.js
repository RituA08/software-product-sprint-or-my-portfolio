// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['Hello world!', '¡Hola Mundo!', '你好，世界！', 'Bonjour le monde!'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}

async function showServerTime() {
    const responseFromServer = await fetch('/hello');
    const response = await responseFromServer.json();
    const messagecontainer = document.getElementById('m-container');
    if (response["comments"].length == 0) {
        messagecontainer.innerHTML = "No comments";
    } else {
        messagecontainer.innerHTML = response["comments"][Math.floor(Math.random() * response["comments"].length)];
    }
}

async function showTranslation(){

    const text = document.getElementById('text').value;
    const languageCode = document.getElementById('language').value;

    const resultContainer = document.getElementById('result');
    resultContainer.innerText = 'Loading...';

    //appends text and language code key/value pair to the URLSearchParams object
    const params = new URLSearchParams();
    params.append('text', text);
    params.append('languageCode', languageCode);

    fetch('/translate', {
      method: 'POST',
      body: params
    }).then(response => response.text()) //read the response
    .then((translatedMessage) => { 
      resultContainer.innerText = translatedMessage;
    });
  }




