<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Inicio</router-link> |
      <router-link to="/products">Produtos</router-link> |
      <router-link to="/stock-movements">Movimento estoque</router-link> |
      <div class="d-inline-block">
        <b-dropdown variant="link" text="Consultas Avançadas" no-caret>
          <b-dropdown-item to="/search-products-by-type">Produto por tipo</b-dropdown-item>
          <b-dropdown-item to="/search-profit-by-product">Lucro por produto</b-dropdown-item>
        </b-dropdown>
      </div> |
      <router-link to="/user">Usuário</router-link> |
      <router-link to="/login">Login</router-link>
    </div>
    <div class="p-4">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
export default {
  name: 'app'
}
</script>

<style lang="scss">
  @import 'custom';

  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    height: 100vh;
    padding: 0;
    margin: 0;
  }
</style>
