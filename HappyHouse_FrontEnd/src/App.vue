<template>
  <v-app id="app" data-app>
    <Header />
    <div style="height: 70px;"></div>
    <router-view />
    <!-- <div style="height:1000px"></div> -->
    <!-- <Footer /> -->
  </v-app>
</template>

<script>
import Header from './components/Header';
// import Footer from './components/Footer';

export default {
  name: 'App',

  components: {
    Header,
    // Footer,
  },

  data: () => ({
    //
  }),
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
#nav {
  padding: 30px;
}
#nav a {
  font-weight: bold;
  color: #2c3e50;
}
#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
