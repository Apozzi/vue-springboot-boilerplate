<template>
  <div class="products">
    <h1>
      Consulta de lucro por produto
    </h1>

    <b-card class="mt-4 mb-2">
      <h5 class="mb-3">
        Lista produtos
      </h5>
      <table class="table table-hover table-dark">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Produto</th>
          <th scope="col">Quantidade total de saida</th>
          <th scope="col">Total de lucro</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th scope="row">1</th>
          <td>TV</td>
          <td>2</td>
          <td>2800</td>
        </tr>
      </tbody>
    </table>
    </b-card>
  </div>
</template>

<script>
  export default {
    name: 'products'
  }
</script>