<template>
  <nav class="dashboard">
    <div class="logo-container">
      <img src="@/assets/tecnm-removebg-preview.png" alt="logo escolar" class="logo" />
    </div>
    <div class="search-container">
      <input type="text" placeholder="Buscar..." class="search-bar" />
    </div>
    <ul class="nav-links">
      <li>
        <a href="/alumno/ajustes">
          <img src="@/assets/sesion.png" alt="usuario" class="icon" />
          <span>Usuario</span>
        </a>
      </li>
    </ul>
  </nav>
</template>

<style scoped>
.dashboard {
  display: flex;
  align-items: center;
  justify-content: space-between;
  background: linear-gradient(90deg, #2196f3, #21cbf3);
  color: white;
  padding: 1rem 2rem;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 1000;
  transition: background 0.3s ease;
}

.dashboard:hover {
  background: linear-gradient(90deg, #21cbf3, #2196f3);
}

.logo-container {
  display: flex;
  align-items: center;
}

.logo {
  height: 50px;
  width: auto;
  transition: transform 0.3s ease;
}

.logo:hover {
  transform: scale(1.1);
}

.search-container {
  flex: 1;
  display: flex;
  justify-content: center;
  margin: 0 2rem;
}

.search-bar {
  width: 100%;
  max-width: 500px;
  padding: 0.7rem;
  border: none;
  border-radius: 20px;
  font-size: 1rem;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
  transition: box-shadow 0.3s ease, transform 0.3s ease;
}

.search-bar:focus {
  outline: none;
  box-shadow: 0 6px 15px rgba(0, 0, 0, 0.3);
  transform: scale(1.05);
}

.nav-links {
  list-style: none;
  display: flex;
  gap: 2rem;
  margin: 0;
  padding: 0;
}

.nav-links li {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  transition: transform 0.3s ease;
}

.nav-links li:hover {
  transform: translateY(-5px);
}

.nav-links a {
  color: white;
  text-decoration: none;
  font-weight: bold;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 0.5rem;
  transition: color 0.3s ease;
}

.nav-links a:hover {
  color: #ffcc00;
}

.icon {
  height: 40px;
  width: 40px;
  transition: transform 0.3s ease;
}

.icon:hover {
  transform: scale(1.2);
}
</style>