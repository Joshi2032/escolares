import { createRouter, createWebHistory } from 'vue-router'
import login from '../components/login.vue' // Importa el componente de login
import Dashboard from '@/components/Dashboard.vue'
import Herramientas from '@/components/Herramientas.vue'
import Registro from '@/components/registro.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/login', // Define la nueva ruta
      name: 'login',
      component: login // Asocia el componente de login
    },
    {
      path: '/dashboard',
      name: 'dashboard',
      component: Dashboard
    },
    {
      path: '/herramientas',
      name: 'herramientas',
      component: Herramientas
    },
    {
      path: '/registro',
      name: 'registro',
      component: Registro
    },
    
  ],
})

export default router
