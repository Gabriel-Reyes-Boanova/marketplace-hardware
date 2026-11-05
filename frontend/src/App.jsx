import { useEffect, useState } from 'react'

export default function App() {
  const [apiStatus, setApiStatus] = useState('Verificando API...')

  useEffect(() => {
    fetch('/api/status')
      .then((response) => {
        if (!response.ok) throw new Error('API indisponível')
        return response.json()
      })
      .then((data) => setApiStatus(`${data.application}: ${data.status}`))
      .catch(() => setApiStatus('Não foi possível conectar à API'))
  }, [])

  return (
    <main className="container">
      <h1>Marketplace</h1>
      <p>Frontend React iniciado com sucesso.</p>
      <p className="status">Backend: {apiStatus}</p>
    </main>
  )
}
