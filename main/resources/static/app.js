const results = document.getElementById('results');

function renderSongs(songs) {
  if (!songs || songs.length === 0) {
    results.innerHTML = '<p class="info">No suggestions for that mood. Try another.</p>';
    return;
  }
  const list = document.createElement('ul');
  songs.forEach(s => {
    const li = document.createElement('li');
    const a = document.createElement('a');
    a.href = s.uri || '#';
    a.target = '_blank';
    a.textContent = `${s.title} — ${s.artist}`;
    li.appendChild(a);
    list.appendChild(li);
  });
  results.innerHTML = '';
  results.appendChild(list);
}

async function fetchSuggestions(mood) {
  results.innerHTML = '<p class="info">Loading...</p>';
  try {
    const res = await fetch(`/api/suggest?mood=${encodeURIComponent(mood)}`);
    if (!res.ok) throw new Error('Network error');
    const data = await res.json();
    renderSongs(data);
  } catch (e) {
    results.innerHTML = `<p class="error">Failed to get suggestions: ${e.message}</p>`;
  }
}

document.querySelectorAll('.mood-buttons button').forEach(btn => {
  btn.addEventListener('click', () => {
    const mood = btn.getAttribute('data-mood');
    fetchSuggestions(mood);
  });
});

document.getElementById('suggestBtn').addEventListener('click', () => {
  const mood = document.getElementById('moodInput').value.trim();
  if (mood) fetchSuggestions(mood);
});

// optional: fetch default suggestions
// fetchSuggestions('happy');
