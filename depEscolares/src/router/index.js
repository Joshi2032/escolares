import { createRouter, createWebHistory } from 'vue-router'
import login from '../components/login.vue' // Importa el componente de login


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/login', // Define la nueva ruta
      name: 'login',
      component: login // Asocia el componente de login
    },
  ],
})

export default router
